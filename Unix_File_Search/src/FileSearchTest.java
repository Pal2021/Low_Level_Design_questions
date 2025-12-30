import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileSearchTest {

    @Test
    public void testFileSearch() {
        // Setup: Create file structure
        final File root = new File(true, 0, "adam", "root");
        final File a = new File(false, 2000, "adam", "a");
        final File b = new File(false, 6000, "george", "b");

        root.addEntry(a);
        root.addEntry(b);

        // Create search criteria: Find files (not directories) owned by someone matching "ge.*"
        final FileSearchCriteria criteria = new FileSearchCriteria(
                new AndPredicate(List.of(
                        new SimplePredicate<>(
                                FileAttribute.IS_DIRECTORY,
                                new EqualsOperator<>(),
                                false
                        ),
                        new SimplePredicate<>(
                                FileAttribute.OWNER,
                                new RegexMatchOperator(),  // Fixed: removed generic
                                "ge.*"  // Fixed: Changed "ge." to "ge.*" to match "george"
                        )
                ))
        );

        // Execute search
        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

        // Assertions
        assertEquals(1, result.size());
        assertEquals("b", result.get(0).getFilename());
        assertEquals("george", result.get(0).getOwner());
    }

    @Test
    public void testSearchBySize() {
        // Setup
        final File root = new File(true, 0, "admin", "root");
        final File small = new File(false, 500, "john", "small.txt");
        final File large = new File(false, 5000, "john", "large.txt");

        root.addEntry(small);
        root.addEntry(large);

        // Search for files > 1000 bytes
        final FileSearchCriteria criteria = new FileSearchCriteria(
                new SimplePredicate<>(
                        FileAttribute.SIZE,
                        new GreaterThanOperator<>(),
                        1000
                )
        );

        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

        assertEquals(1, result.size());
        assertEquals("large.txt", result.get(0).getFilename());
    }

    @Test
    public void testOrPredicate() {
        // Setup
        final File root = new File(true, 0, "admin", "root");
        final File file1 = new File(false, 500, "adam", "file1.txt");
        final File file2 = new File(false, 2000, "george", "file2.txt");
        final File file3 = new File(false, 1000, "alice", "file3.txt");

        root.addEntry(file1);
        root.addEntry(file2);
        root.addEntry(file3);

        // Find files owned by "adam" OR size > 1500
        final FileSearchCriteria criteria = new FileSearchCriteria(
                new OrPredicate(List.of(
                        new SimplePredicate<>(
                                FileAttribute.OWNER,
                                new EqualsOperator<>(),
                                "adam"
                        ),
                        new SimplePredicate<>(
                                FileAttribute.SIZE,
                                new GreaterThanOperator<>(),
                                1500
                        )
                ))
        );

        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

        assertEquals(2, result.size());  // file1 (adam) and file2 (size 2000)
    }

    @Test
    public void testNotPredicate() {
        // Setup
        final File root = new File(true, 0, "admin", "root");
        final File subDir = new File(true, 0, "admin", "subdir");
        final File file = new File(false, 1000, "john", "file.txt");

        root.addEntry(subDir);
        root.addEntry(file);

        // Find everything that is NOT a directory
        final FileSearchCriteria criteria = new FileSearchCriteria(
                new NotPredicate(
                        new SimplePredicate<>(
                                FileAttribute.IS_DIRECTORY,
                                new EqualsOperator<>(),
                                true
                        )
                )
        );

        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

        assertEquals(1, result.size());
        assertEquals("file.txt", result.get(0).getFilename());
    }

    @Test
    public void testNestedDirectories() {
        // Setup: Create nested structure
        final File root = new File(true, 0, "admin", "root");
        final File dir1 = new File(true, 0, "admin", "dir1");
        final File dir2 = new File(true, 0, "admin", "dir2");
        final File fileA = new File(false, 1000, "john", "a.txt");
        final File fileB = new File(false, 2000, "john", "b.txt");
        final File fileC = new File(false, 3000, "alice", "c.txt");

        root.addEntry(dir1);
        root.addEntry(dir2);
        dir1.addEntry(fileA);
        dir1.addEntry(fileB);
        dir2.addEntry(fileC);

        // Search for all files owned by "john"
        final FileSearchCriteria criteria = new FileSearchCriteria(
                new SimplePredicate<>(
                        FileAttribute.OWNER,
                        new EqualsOperator<>(),
                        "john"
                )
        );

        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(f -> f.getFilename().equals("a.txt")));
        assertTrue(result.stream().anyMatch(f -> f.getFilename().equals("b.txt")));
    }
}
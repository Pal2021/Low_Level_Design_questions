
import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class File {

    private final boolean isDirectory;
    private final int size;
    private final String owner;
    private final String filename;
    private final Set<File>entries=new HashSet<>();

    public File(boolean isDirectory, int size, String owner, String filename) {
        this.isDirectory = isDirectory;
        this.size = size;
        this.owner = owner;
        this.filename = filename;
    }
    public Object extract(final FileAttribute fileAttribute) {
        switch (fileAttribute) {
            case SIZE1 -> {
                return size;
            }
            case OWNER -> {
                return owner;
            }
            case FILENAME -> {
                return filename;
            }
            case IS_DIRECTORY -> {
                return isDirectory;
            }

        }
        throw new IllegalArgumentException("invalid filter criteria type");
    }

    public void addEntry(final File entry){
        entries.add(entry);
    }
    public Set<File> getEntries() {
        if (!isDirectory) {
            return Collections.emptySet();
        }
        return new HashSet<>(entries);
    }

}

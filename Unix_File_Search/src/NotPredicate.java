public class NotPredicate implements CompositePredicate{

    private final Predicate operand;

    public NotPredicate(final Predicate predicate) {
        this.operand = predicate;
    }

    @Override
    public boolean isMatch(File inputFile) {
        return !operand.isMatch(inputFile);
    }
}

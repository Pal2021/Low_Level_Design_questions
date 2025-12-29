public class SimplePredicate<T> implements Predicate {

    private final FileAttribute attribute;
    private final ComparisonOperator<T> operator;
    private final T expectedValue;


    public SimplePredicate(final FileAttribute attribute,
                           final ComparisonOperator<T> operator,
                           final T expectedValue) {
        this.attribute = attribute;
        this.operator = operator;
        this.expectedValue = expectedValue;
    }


    @Override
    public boolean isMatch(final File inputfile) {
        Object actualValue= inputfile.extract(attribute);
        if(expectedValue.getClass().isInstance(actualValue)){
            return operator.isMatch((T)actualValue,expectedValue);
        }else{
            return false;
        }
    }
}
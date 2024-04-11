public class BaseProposition extends Proposition{
    protected boolean value;
    // protected String sentence;/

    public BaseProposition(boolean value) {
        this.value = value;
        // this.sentence = sentence;
    }

    @Override
    public boolean eval() {
        return this.value;
    }

    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub
    //     return this.sentence;
    // }

    
}

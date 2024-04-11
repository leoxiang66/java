public class Negation extends UnaryOperation{

    public Negation(Proposition p1) {
        super(p1);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean unaOp(Proposition p1) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'unaOp'");
        return !p1.eval();
    }
    
}

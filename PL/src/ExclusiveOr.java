public class ExclusiveOr extends BinaryOperation{

    public ExclusiveOr(Proposition p1, Proposition p2) {
        super(p1, p2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean binOp(Proposition p1, Proposition p2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'binOp'");
        if (p1.eval() != p2.eval()) {
            return true;
        }
        
        return false;
    }
    
}

public class Or extends  BinaryOperation {
    
    public Or(Proposition p1, Proposition p2) {
        super(p1, p2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean binOp(Proposition p1, Proposition p2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'binOp'");

        if (p1.eval() == false && p2.eval() == false) {
            return false;
        }
        
        return true;
    }


    
}

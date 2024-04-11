public class Implication extends BinaryOperation{

    public Implication(Proposition p1, Proposition p2) {
        super(p1, p2);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean binOp(Proposition p1, Proposition p2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'binOp'");
        /*
         * 
         * 10 => false; 其他为true
         */
        if (p1.eval() == true && p2.eval() == false) {
            return false;
        }
        
        return true;
    }
    
}

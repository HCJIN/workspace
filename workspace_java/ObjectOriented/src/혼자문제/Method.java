package 혼자문제;

public class Method {
        private int x;
        private int y;

        public void A(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    class B extends Method{
        private int x1;
        private int y1;

        public B(){
            setX(1);
            setY(1);
            this.x1 = 1;
            this.y1 = 1;
        }

        public B(int x){
            setX(x);
            setY(1);
            this.x1 = 1;
            this.y1 = 1;
        }

        public B(int x, int y){
            setX(x);
            setY(y);
            this.x1 = 1;
            this.y1 = 1;
        }

        public B(int x, int y, int x1, int y2){
            setX(x);
            setX(y);
            this.x1 = x1;
            this.y1 = y1;
        }



        public void B(int x, int y,  int x1, int y1){
            setX(x);
            setX(y);
            this.x1 = x1;
            this.y1 = y1;
        }


        public void disp(){
            System.out.println("X = " + getX() + " Y = " + getY() + " X = " + this.x1 + " Y = " + this.y1);
        }
    }


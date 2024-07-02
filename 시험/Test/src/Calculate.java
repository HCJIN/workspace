public class Calculate {
    private int num1;
    private int num2;

    void setNumber(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    int getSum(){
        return this.num1 + this.num2;
    }

    int getMax(){
        return (this.num1 > this.num2) ? this.num1 : this.num2;
    }

    double getAvg(){
        int max = 0;
        int min = 0;
        int sum = 0;
        int cnt = 0;
        if (num1 > num2){
            max = num1;
            min = num2;
        }else if(num2 > num1){
            max = num2;
            min = num1;
        }
        for (int i = min + 1; i < max; i++){
            sum = sum + i;
            cnt++;
        }
        return sum / (double)cnt;
    }



}

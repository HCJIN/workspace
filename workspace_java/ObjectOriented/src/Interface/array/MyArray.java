package Interface.array;

public class MyArray implements MyArrayUtil{

    //매개변수로 받은 두 배열의 모든 요소의 평균을 리턴
    @Override
    public double getTwoArrayAvg(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for(int i = 0; i < arr2.length; i++){
            arr3[i+arr1.length] = arr2[i];
        }
        for (int i = 0; i < arr3.length; i++){
            sum = sum + arr3[i];
        }
        avg = sum / arr3.length;
        return avg;
    }

    //매개변수로 받은 배열의 모든 요소가 짝수일때만 리턴 true.
    @Override
    public boolean isEvenArray(int[] array) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                cnt++;
            }
        }
        return cnt == array.length ? true : false;
    }
}

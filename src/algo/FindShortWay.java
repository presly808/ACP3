package algo;

/**
 * Created by admin on 03.12.2014.
 */
public class FindShortWay {


    int[][] mas = {

            {0,0,0,0,0,0},
            {0,1,1,1,1,0},
            {0,1,1,1,1,0},
            {0,1,1,8,1,0},
            {0,1,1,0,1,0},
            {0,0,0,0,0,0},

    };

    public void go(int way, int i, int j) throws InterruptedException {
        print();
        Thread.sleep(500);
        if(!inRange(i,j)){
            return;
        }

        //found place
        if(mas[i][j] == 8){
            return;
        }

        //
        if(way <= mas[i][j]){
            mas[i][j] = way;
        } else {
            return;//todo check this place
        }

        //way
        way++;
        go(way, i+1, j); // down

        go(way, i, j + 1); // right

        go(way, i, j - 1); // left

        go(way, i - 1, j); // up

    }

    public void print(){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public boolean inRange(int i, int j){
        return (i >=0 && i < mas.length) && (j >= 0 && j < mas.length);
    }

    public static void main(String[] args) throws InterruptedException {
        new FindShortWay().go(1, 0, 0);
    }


}

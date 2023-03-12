package sort;

import java.util.Arrays;

public class pg_42748 {
    public int[] sliceArr(int[] array, int[] command) {
      int[] res = Arrays.copyOfRange(array, command[0] - 1, command[1]);
      return res;
    }

    public int[] solution(int[] array, int[][] commands) {
      int loop = commands.length;
      int[] answer = new int[loop];

      for (int i = 0; i < loop; i++) {
        int[] slice = sliceArr(array, commands[i]);
        Arrays.sort(slice);
        answer[i] = slice[commands[i][2] - 1];
      }
      return answer;
    }
}

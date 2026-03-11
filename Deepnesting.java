'DeepNesting': '''
public class DeepNesting {
  public int compute(int[][] matrix) {
    int result = 0;
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<matrix[i].length;j++) {
        if(matrix[i][j] > 0) {
          for(int k=0;k<matrix[i][j];k++) {
            if(k%2==0) { if(k>10) { if(result<1000) { result += k*matrix[i][j]; } } } 
          }
        }
      }
    }
    return result;
  }
}''',

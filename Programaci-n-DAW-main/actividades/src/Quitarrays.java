public class Quitarrays {
    public static void main(String[] args) {
      int vector[]={2,3,5,7,8,2};
      int contador=0;
      for(int i=0;i<vector.length;i++){
          if(vector[i]==2) contador++;
      }
      int vector2[]=new int[vector.length-contador];
      for (int i=0;i<vector2.length;i++)
           if(vector[i]!=2){
             vector2[1]=vector[i];
           }
    }
}

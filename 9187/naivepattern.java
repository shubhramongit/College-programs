public class naivepattern {
    static void patSearching(String txt,String pat){
      int  m = pat.length();
      int n = txt.length();
      for(int i=0;i<=(n-m);i++){
          int j;
          for(j=0;j<m;j++)
              if(pat.charAt(j)!=txt.charAt(i+j))
                  break;
                  if(j==m)
                  System.out.println("Pattern found at index "+i);
    }
  }
        public static void main(String[] args) {
          String txt = "ABCABCD";
          String pat = "ABC";
          System.out.print("All index numbers where pattern found are: ");
          patSearching(txt, pat);
          }
          }
      
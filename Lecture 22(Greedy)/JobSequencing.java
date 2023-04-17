import java.util.*;
class JobSequencing {
      class Job{
            int id;
            int deadline;
            int profit;

            public Job(int i,int d,int p){
                  id = i;
                  deadline=d;
                  profit = p;
            }
      }
      
      public static void main(String args[]){
            int jobSeq [][] ={{4,20},{1,10},{1,40},{1,30}};
            ArrayList<Job> jobs= new ArrayList<>();
            JobSequencing js = new JobSequencing();

            for(int i=0;i<jobSeq.length;i++){
                  jobs.add(js.new Job(i,jobSeq[i][0],jobSeq[i][1]));
            }

            Collections.sort(jobs,(a,b) -> b.profit - a.profit);
            ArrayList<Integer> seq= new ArrayList<>();
            int time=0;

            for(int i=0;i<jobs.size();i++){
                  Job curr = jobs.get(i);
                  if(curr.deadline > time){
                        time++;
                        seq.add(curr.id);
                  }
            }
            char C[] ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            for(int i=0;i<seq.size();i++){
                  System.out.print(C[seq.get(i)] +" ");
            }

      }
}
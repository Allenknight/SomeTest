package hsj.whatever.com.selfviewdemo.nothing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import org.apache.http.client.*;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;

/**
 * Created by AllenHan on 2017/11/17.
 */

public class tst {

////    MultipartEntityBuilder
//    HttpClientBuilder httpClientBuilder = HttpClientBuilder.c

    public void main(){
        Permutation("asds", "adsf");
    }

    public boolean Permutation(String A, String B) {
        // write your code here
        List<String> mList = new ArrayList<>();
        List<String> mList2 = new ArrayList<>();
        boolean result = false;
        int two = 0;
        if(A.length() != B.length()){
            return false;
        }
        for(int i = 0; i < A.length(); i++){
            mList.add(A.substring(i, i+1));
        }
        for(int i = 0; i < B.length(); i++){
            mList2.add(A.substring(i, i+1));
        }

        Iterator<String> itr = mList.iterator();
        while(itr.hasNext()){
            int flag = 0;
            for(int j = 0; j < B.length(); j++){
                if(itr.next().equals(mList2.get(j))){
                    flag = 1;
                    itr.remove();
                    break;
                }
            }
            if(flag == 0)
                break;
            two=two+flag;
        }
        if(two == A.length())
            result = true;
        return result;

//        for(int i = 0; i < A.length(); i++){
//            int flag = 0;
//            int num = mList2.size();
//            for(int j = 0; j < num; j++){
//                if(mList.get(i).equals(mList2.get(j))){
//                    flag = 1;
//                    mList2.remove(j);
//                    break;
//                }
//            }
//            if(flag == 0){
//                break;
//            }
//            two=two+flag;
//        }
//        if(two == A.length())
//            result = true;
//        return result;
    }

//    public void mmain()throws JsonGenerationException, JsonMappingException, IOException{
//
//    }
//    ObjectMapper mapper = new ObjectMapper();
}

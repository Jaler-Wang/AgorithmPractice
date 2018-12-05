package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visitTimes = new HashMap<String, Integer>();
        if(cpdomains == null || cpdomains.length == 0){
            return null;
        }
        for(int i = 0; i < cpdomains.length; i++){
            String[] data = cpdomains[i].split(" ");
            int times = Integer.parseInt(data[0]);
            String domain = data[1];
            do{
                if(visitTimes.containsKey(domain)){
                    visitTimes.put(domain, visitTimes.get(domain) + times);
                }
                else{
                    visitTimes.put(domain, times);
                }
                int index = domain.indexOf(".");
                if(index == -1){
                    domain = null;
                }
                else {
                    domain = domain.substring(index + 1);
                }
            } while(domain != null);
        }
        List<String> result = new ArrayList<String>();
        for(Map.Entry entry: visitTimes.entrySet()){
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    @Test
    public void test(){
        String[] data = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(data));
    }

    @Test
    public void test2(){
        String[] data = new String[]{"900 google.mail.com"};
        System.out.println(subdomainVisits(data));
    }
}


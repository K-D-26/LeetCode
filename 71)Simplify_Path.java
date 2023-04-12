// Using StringBuilder    (4 ms)

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/", 0);
        
        // String printed = Arrays.toString(arr);
        // System.out.println(printed);
        
        Stack<String> st = new Stack<>();
        int cnt = 0;
        
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i].equals(".") || arr[i].equals(""))
                continue;
            else if(arr[i].equals("..")) {
                cnt++;
                continue;
            }
            else {
                if(cnt == 0)
                    st.push(arr[i]);
                else if(cnt > 0)
                    cnt--;
            }
        }
        
        if(st.size() == 0)
            return "/";
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            String s = "/" + st.pop();
            sb.append(s);
        }
        
        return sb.toString();
    }
}


// Using String   (7 ms)

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/", 0);
        
        Stack<String> st = new Stack<>();
        int cnt = 0;
        
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i].equals(".") || arr[i].equals(""))
                continue;
            else if(arr[i].equals("..")) {
                cnt++;
                continue;
            }
            else {
                if(cnt == 0)
                    st.push(arr[i]);
                else if(cnt > 0)
                    cnt--;
            }
        }
        
        if(st.size() == 0)
            return "/";
        
        String sb = "";
        while(!st.isEmpty()) {
            sb += "/" + st.pop();
        }
        
        return sb;
    }
}

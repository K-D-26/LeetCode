class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_u == ulp_v) return;
        
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_u == ulp_v) return;
        
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<String>();
        }
        
        for (Map.Entry<String, Integer> e : mapMailNode.entrySet()) {
            String mail = e.getKey();
            int node = ds.findUParent(e.getValue());
            mergedMail[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        
        return ans;
    }
}
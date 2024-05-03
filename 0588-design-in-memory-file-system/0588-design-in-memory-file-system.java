class FileSystem {
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir curr = root;
        List<String> list = new ArrayList<>();
        String[] ps = path.split("/");
        int n = ps.length;
        for (int i = 1; i < n - 1; i++) { 
            String p = ps[i];
            curr = curr.dirs.get(p);
        }
        
        if (n > 1) {
            String last = ps[n - 1];
            if (curr.files.containsKey(last)) { // the last one is a file name
                list.add(last);
                return list;
            } else { //the last one is a folder
                curr = curr.dirs.get(last);
            }
        }
        
        //get all the folder names and file names under curr dir
        for (String f : curr.dirs.keySet()) list.add(f);
        for (String f : curr.files.keySet()) list.add(f);
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        Dir curr = root;
        
        String[] ps = path.split("/");
        int n = ps.length;
        for (int i = 1; i < n; i++) {
            String p = ps[i];
            if (!curr.dirs.containsKey(p)) curr.dirs.put(p, new Dir());
            curr = curr.dirs.get(p);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir curr = root;
        String[] ps = filePath.split("/");
        int n = ps.length;
        for (int i = 1; i < n - 1; i++) {
            String p = ps[i];
            curr = curr.dirs.get(p);
        }
        
        String fileName = ps[n - 1];
        curr.files.put(fileName, curr.files.getOrDefault(fileName, "") + content);
        
    }
    
    public String readContentFromFile(String filePath) {
        Dir curr = root;
        String[] ps = filePath.split("/");
        int n = ps.length;
        for (int i = 1; i < n - 1; i++) {
            String p = ps[i];
            if (!curr.dirs.containsKey(p)) curr = new Dir();
            curr = curr.dirs.get(p);
        }
        
        String fileName = ps[n - 1];
        return curr.files.get(fileName);
    }
    
    class Dir {
        Map<String, Dir> dirs = new HashMap<>(); // directory name -> dirs
        Map<String, String> files = new HashMap<>(); //file name -> content
        
        public Dir(){}
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
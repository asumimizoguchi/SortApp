public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] name;
        List<String> nameList = new ArrayList<String>();
        // Read file
        read(nameList);
        //Sort in ascending order of string length
        nameList.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        // convert list of names to array
        name = (String[])nameList.toArray(new String[0]);

        for (String theName : name) {
            System.out.println(theName);
        
        }
             
    int res;
        do {
            System.out.println();  
            System.out.println("Please select (1 or 0) ");  
            System.out.println("1. Descending order: ");
            System.out.println("0. Exit: ");
                        
            res = in.nextInt();
            if (res == 1){
            //Sort in descending order of string length
            nameList.sort(Comparator.comparing(String::length).reversed().thenComparing(Comparator.reverseOrder()));
            // convert list of names to array
            name = (String[])nameList.toArray(new String[0]);

            for (String theName : name) {
                System.out.println(theName);
            }
        System.out.println(); 
            }
            }while (res != 0);
              
}

private static void read(List<String> nameList) {
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(FILE_PATH));
        String line = br.readLine();
        // Read file
        while (line != null) {
            String[] array = line.strip().split("\n");
            
            if (array.length != 0) {
                nameList.add(array[0]);
                line = br.readLine();
            }
                            
        }
        
    //Error handling
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
    try {
        if (br != null) {
            br.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
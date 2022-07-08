   - list + itorator
   ```
               List<Integer> testArrayList = new ArrayList<Integer>();
               testArrayList.add(1);
               testArrayList.add(2);
               testArrayList.add(3);
               testArrayList.add(4);
               testArrayList.add(5);

               System.out.println(testArrayList);
               for (Iterator<Integer> iter = testArrayList.iterator(); iter.hasNext(); ) {
                   int value = iter.next();
                   if (value==3) {
                       iter.remove();
                   }
               }
               System.out.println(testArrayList);

   ```

   - Hash set
   ```
           Set<String> hSet = new HashSet<String>();
          //  Set<String> hSet = new TreeSet<String>(); 정렬

           hSet.add("Java");
           hSet.add("Javascript");
           hSet.add("C");
           hSet.add("C++");
           hSet.add("Javascript");
           System.out.println(hSet.size());

           for(Iterator<String> itr = hSet.iterator(); itr.hasNext();){
               System.out.println(itr.next());
           }


   ```

   - MAp
   ```
   Map<Integer, String> map = new HashMap<Integer, String>();
   ```
   - Comparator
   ```
           Collections.sort(list, new Comparator<Student>() {
               @Override
               public int compare(Student s1, Student s2) {
                   if (s1.getScore() < s2.getScore()) {
                       return -1;
                   } else if (s1.getScore() > s2.getScore()) {
                       return 1;
                   }
                   return 0;
               }
           });
   ```
   - Map 정렬
   ```
   Map<string, string=""> map = new HashMap<>();

           map.put("A", "29");
           map.put("C", "19");
           map.put("D", "31");
           map.put("B", "15");

           List<string> keySetList = new ArrayList<>(map.keySet());
           // 내림차순 //
           Collections.sort(keySetList, new Comparator<string>() {
               @Override
               public int compare(String o1, String o2) {
                   return map.get(o2).compareTo(map.get(o1));
               }
           });

           for(String key : keySetList) {
               System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
           }

           System.out.println("-----------------------------------------------------------------");

           // 오름차순 //
           Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

           for(String key : keySetList) {
               System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
           }
   ```
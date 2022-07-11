## list + itorator
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

## Hash set
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

## MAp
   ```
   Map<Integer, String> map = new HashMap<Integer, String>();
   ```
## Comparator
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

## Map key 정렬
```java
		Map<Integer, String> testMap = new LinkedHashMap<Integer, String>();

        // Map에 데이터 추가
        testMap.put( 1, "apple");
        testMap.put( 4, "pineapple");
        testMap.put( 2, "orange");
        testMap.put( 5, "strawberry");
        testMap.put( 3, "melon");

        // 키로 정렬 - 오름차순
        Object[] mapkey = testMap.keySet().toArray();
        Arrays.sort(mapkey);
        System.out.println("=============");
        // 결과 출력
        for (Object nKey : mapkey)
        {
        System.out.println(testMap.get(nKey));
        }

        // 정렬 - 내림차순
        Arrays.sort(mapkey, Collections.reverseOrder());
        System.out.println("=============");
        // 결과 출력
        for (Object nKey : mapkey)
        {
        System.out.println(testMap.get(nKey));
        }
```
## Map value 정렬
   ```
   Map<String, String> map = new HashMap<>();

           map.put("A", "29");
           map.put("C", "19");
           map.put("D", "31");
           map.put("B", "15");

           List<String> keySetList = new ArrayList<>(map.keySet());
           // 내림차순 //
           Collections.sort(keySetList, new Comparator<String>() {
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
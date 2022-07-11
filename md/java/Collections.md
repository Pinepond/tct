## list + itorator
```java
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
```java
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
```java
Map<Integer, String> map = new HashMap<Integer, String>();
```
## Comparator
```java
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

## Map key 정렬 / List 정렬 
Map 정렬이 결국 keyset 을 list 로 만들어서 정렬하므로 같은내용임
```java
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "29");
        map.put(3, "19");
        map.put(2, "31");
        map.put(4, "15");

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 - 3가지 방식 //
        Collections.sort(keySetList, Comparator.reverseOrder());
        Collections.sort(keySetList, (o1, o2) -> (o2 - o1));
        Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int key : keySetList) {
        System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }

        System.out.println("-----------------------------------------------------------------");

        // 오름차순 - 3가지 방식 //
        Collections.sort(keySetList, Comparator.naturalOrder());
        Collections.sort(keySetList, (o1, o2) -> (o1 - o2));
        Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int key : keySetList) {
        System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }
        
```

## Map value 정렬
```java
        Map<String, String> map = new HashMap<>();

        map.put("A", "29");
        map.put("C", "19");
        map.put("D", "31");
        map.put("B", "15");

        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 - 3가지 방식 //
        Collections.sort(keySetList, Comparator.comparing(map::get).reversed());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        for (String key : keySetList) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }

        System.out.println("-----------------------------------------------------------------");

        // 오름차순 - 3가지 방식 //
        Collections.sort(keySetList, Comparator.comparing(map::get));
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        for (String key : keySetList) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }
        
```
package com.epam.code_with_mosh.string_manipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiou";
        if (str == null) {
            return 0;
        }
        //aeiou
        //we can store vowels in hashset and then lookup the value bcoz lookup in hashset is o(1)
        // if dealing with really large string then we can use  sets
        for (var ch : str.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1)
                count++;
            //      if (vowels.contains(Character.toString(ch)))
        }
        return count;
    }

    public static String reverse(String str) {
        if (str == null)
            return "";
        //we are not using null beacuse if we perform any operation
        //on that string that we are string then that might give error
        //eg== abc.length() if null then give error
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));//o(1)
        return reversed.toString();

//        String reversed="";
//        for(var i=string.length();i>=0;i--)//O(n)
//        {
//            reversed += string.charAt(i);
//            //time complexicity O(n)== because it grows linearly and direct propotino to
//            // to the size of the string object that gets increased in each step
//            // in this line every time we append new character we are creating new
//            //string object and all the character in the current string are being copied to the new string
//            //as our string grows larger the number of char. that should be copied to the new string object also increses
//
//        }
//        return reversed;
//        //O(n*N) for whole operation this methods gets very slow as our input grows very large
//        //as we know string is immutable in java and most programming language
//        //means when we create string in java we cannot modify it
//        //any changes in string  results in creation of new string object in string
//        //so the original string remains unaffected
//        //stringBuilder is mutable in java we do not require to create new object every time
    }

    //Trees are beautiful
    //beautiful are Trees
    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";
        String[] words = sentence.trim().split(" ");
        //we can add this words in stack and then pop them all
        //it will come out in reverse order
        Collections.reverse(Arrays.asList(words)); //we can only pass list in collection we can't use arrays
        return String.join(" ", words);  //this method combines all the items in array with delimeter ie wide space
//        StringBuilder reversed=new StringBuilder();
//        for (int i = words.length - 1; i >= 0; i--)
//            reversed.append(words[i]+" ");
//
//        return reversed.toString().trim();
    }

    //ABCD ->DABC   ROTATION BY 1 CHAR RIGHT
    //     ->CDAB  ROTATION BY 2 CHAR RIGHT
    //      ->BCDA ROTATION BY 3 CHAR RIGHT
    //      ->ABCD  ROTATION BY 4 CHAR RIGHT
    // PATTERN ->input and o/p have exact same length they both have 4 char.
    // and order of char is always same for e.g :- d always comes after c you can see in pattern
    // the only thing if you are at end you have to start from the begining but order of char. does not changes
    //approach 2 concat first with second
    //ABCDABCD
    public static boolean areRotations(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        return (s1.length() == s2.length() && (s1 + s1).contains(s2));
        //if input string is really large 1 million char. as  part of concatination
        //we have to allocate 2 million char. thats alot of space so in tht case
        //it will be better to use for loop and compare the char in both strings
        //approach 1-
        //find first char of s1 and s2 then go forward  make sue all the subsequent character are the same
        //when we get end of string we should start from begining
//        if(s1.length() != s2.length()) return false;
//        if(!(s1+s1).contains(s2)) return false;
    }

    public static String removeDuplicates(String s) {
        if (s == null)
            return "";
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<Character>();
        for (var ch : s.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccurence(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;//table that map char to numeric value
        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray()) {
            frequencies[ch]++;// initially when we create this integer array (frequencies) will have all the items to zero value
            // for eg we get frequencies['a'] it(java runtime) will convert 'a' to its numeric value to 61 i.e.
            //frequencies[61] will be incremented by 1 initially all the 256 index have zero values
            //a
//            frequencies['a']=5;
//            frequencies[61]=5;
        }
        int max = 0;
        char result = ' ';//initially set to space
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];//we check all index with value and update max value and also result updated
                result = (char) i; //to  'i' ascii char value like 61 index have 'a' value then result store 'a'
            }

        }
        return result;
//        Map<Character, Integer> frequencies = new HashMap<Character,Integer>();
//        for(char ch : str.toCharArray()){
//            if(frequencies.containsKey(ch)){
//                frequencies.replace(ch, frequencies.get(ch)+1);
//            }
//            else
//                frequencies.put(ch,1);
//        }
    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";
        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();//words[i] means first word string substring(0,1)
            // 0 mean starting point and get only 1 single character
            //substring(1).toLowerCase() means convert all character to lowercase starting from 1
            //replaceAll(" +"," ") is multiple spaces with single space
            //+ sign have special meaning in regular expressions that means the character before
            //+ ie " " that one or more widespaces then replace it with single space replacement
            //substring(i,j) gives string from start from index i and till j-1 string return
            //eg monkey.substring(3,5) gives "ke"
            //eg monkey.substring(3) gives "key" //it wii start from 3 and goes all the way end of string
        }
        return String.join(" ", words);//combine all the index with " " concating this space
    }
    //two string are anagram of each other means
    //they have the same character but in different sequences
    //abcdef -befcda are anagrams of each other bcoz they have the exact same
    //character at different orders
    // different ways to solve the problem
    //1st
    //we converts each string to char array
    //first string will get ['a','b','c','d','e'.'f']
    //second string will have  ['b','e','f','c','d','a']
    // then we sort this array the second will became
    //second string will get ['a','b','c','d','e'.'f']
    //finally compare this array for equality

    //O(n)
    public static boolean areAnagrams(String first, String second) {
        //counting the number of occurrence of each char. in first sting and then comparing with second
        //string count of char
        if (first == null || second == null)
            return false;
        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];
        first = first.toLowerCase();
        for (int i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;//97
        //if current char. is 'a' then its asci value is 97 so first.charAt(i)=a=97
        // frequencies[97-97]==frequencies[0] once added we increase the value by 1
        //if another time appear a then frequencies[0]==2

        //2 options 1st is count the second string frequencies and then compare both of them
        //2nd op we can iterate over the second string for each char. we reduce the frequency in frquency array
        second = second.toLowerCase();
        for (int i = 0; i < second.length(); i++) {
            var index = frequencies[second.charAt(i) - 'a'];
            if (index == 0)
                return false;
            index--;
            // if the freq. are equals the value at this index should never became zero
            //for eg if we have 3 a's in our first string we should be able to decrement this value 3 times
            //so only after the loop the value became zero not inside this for loop so if we get zero
            //that means in the second string we have fewer occurances of the current character so before
            //we decrement the value we check wether any index have zero we return false immediately
        }
        return true;
    }

    //O(nlogn) time comp>O(n)
    public static boolean areAnagram1(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            // we can read length of string in constant time remember that first.length() !=second.length()
            // he added this code bcoz  i assume that the  first or second string can be millions char. long
            //if there are not if there are only few hundred or thousand char. long we dont really need to
            //add this extra code over there specially if this code is not gonna executed alot
            //lets this code is used once in while so we dont need to optimize this
            // quote saying by comp. scient.  premature optimization is root of all evils
            //bcoz optimizing code affect its readablity and mainatability in this case addding this extra condition
            //is not a big deal it didn't affect our code alot but if we remove , we can see our code is cleaner and
            //easier to read so before optimizing your code always takes the context in to account see if you
            //really dealing with large input or a lot of load on your application
            //as the business is these code gonna execute a lot of time a day if not you don't really need to
            //optimize this code at the cost of it's maintanability and readability
            //if you are going for coding interview always ask the interviewer about the size of input so
            //you know what kind of problem you are dealing with
            //that separate s/w eng. to code monkey ==who writes code without really understanding what they are doing,without understanding thr problem
            // s/w eng.  who developes proerly engineered solution to todays problem not tomorrows problem that may never happen
            return false;
        //O(n)
        var array1 = first.toLowerCase().toCharArray();
        //O(nlog(n))
        Arrays.sort(array1);
        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        //O(n)
        return Arrays.equals(array1, array2);

        //lets imagine that the first or second string each can be 1 million character long
        //in that case converting into lowercase ,then character array and then finally sorting
        //them can be costly ,now before we do any of this these two string have exact same
        //length if they don't then they are definitly not anagram of each other so there is
        //no point converting them into lowercase then char array and then sort so
    }

    //palindrom means read from left to right will be same
    //for eg ABBA is palindrom reading from right or left will be same
    //  MadaM
    //simplest and more obvious solution is reverse the string and compare witj itself
    public static boolean isPalindrom(String str) {
        //        var input=new StringBuilder(str);
//        String reverse=input.reverse().toString();
//        return  str.equals(reverse);


        //in this solution we have to iterate this word 4 time once adding into string builder,once to reverse,convert to string,once to check for
        //equality not a big deal for small String
        //faster approach
        //define 2 pointers l & r
        //intially define left to zero and right to index of the first char now we compare the character at these pointer
        //if not equal then string is not palindrom so we return false otherwise we bring pointers inward increemt left pointer
        //decrement right pointer again we comp. char and goes on and on as long as left is less than right
        //the moment left crosses right we stop comparing and return true in this approach
        //we donot have to iterate input string 4 times, we iterate half of char. beacse in each step of iteration we comp.
        //to char so the moment we get to middle we are done
        if (str == null)
            return false;
        int left = 0;
        int right = str.length() - 1;
        while (left < right)
            if (str.toLowerCase().charAt(left++) != str.toLowerCase().charAt(right--))
                return false;
        return true;
    }
}

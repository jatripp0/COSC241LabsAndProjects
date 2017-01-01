package project;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class containing methods that find words that match the phone number input.
 * These methods satisfy the bonus points requirements for COSC 241 Project 2.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class WordMatcher {
    
    /**
     * Gets words that match the given numerical input constrained by the range
     * parameters.
     * @param words the list of words to search.
     * @param number the numerical input to be compared against the list of words.
     * @param possibleStart the lower bound range constraint of possible words.
     * @param possibleEnd the upper bound range constraint of possible words.
     * @return a list of strings containing matches of the numerical input.
     */
    public static List<String> getWords(List<String> words, String number, String possibleStart, String possibleEnd){
        List<String> matchList = new ArrayList<>();
        //A pattern using the Regular Expression equivalent of the number.
        Pattern p = Pattern.compile(NumberModifiers.getRegex(number));
        Matcher m;
        
        //Utilizes the binarySearch method of the Java Collections library to locate the beginning and end indices of the range.
        int start = Collections.binarySearch(words, possibleStart);
        if(start < 0){
            start = (start * -1)-1;
        }
        
        int end = Collections.binarySearch(words, possibleEnd);
        if(end < 0){
            end = (end * -1)-1;
        }
        for(int i=start; i<end; ++i){
            if(words.get(i).length() <= number.length()){
                m = p.matcher(words.get(i));
                if(m.matches()){
                    //Format the entry to the list of matches differently if the matching word is seven letters exactly.
                    if(words.get(i).length() == 7){
                        matchList.add(words.get(i).substring(0, 3).toUpperCase()
                                + "-" + words.get(i).substring(3).toUpperCase() 
                                + "  (" + words.get(i).toUpperCase() + ")");
                    } else {
                        //Add words with 6 and fewer letters to the list of matches.
                        matchList.add(words.get(i).toUpperCase());
                    }
                } 
            }
        }
        return matchList;
    }
    
    /**
     * Gets all two word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words.
     */
    public static void getTwoWordCombos(List<String> words, String number){
        int i;
        
        for(i=1; i<number.length()-1; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            
            String sSplit = number.substring(i);
            String s1 = NumberModifiers.numToStart(sSplit);
            String s2 = NumberModifiers.numToEnd(sSplit);
            
            List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
            
            if(!list1.isEmpty() && !list2.isEmpty()){
                for(String s : list1){
                    for(String t : list2){
                        Project2.resultsList.add(s + "-" + t);
                        Project2.comboListSize++;
                    }
                }
            }
        }
    }
    
    /**
     * Gets all three word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words.
     */
    public static void getThreeWordCombos(List<String> words, String number){
        int i,j;
        
        for(i=1; i<number.length()-2; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            for(j=i+1; j < number.length()-1; ++j){
                String sSplit = number.substring(i,j);
                String s1 = NumberModifiers.numToStart(sSplit);
                String s2 = NumberModifiers.numToEnd(sSplit);
                
                String tSplit = number.substring(j);
                String t1 = NumberModifiers.numToStart(tSplit);
                String t2 = NumberModifiers.numToEnd(tSplit);

                List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
                List<String> list3 = WordMatcher.getWords(words, tSplit, t1, t2);
                
                if(!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty()){
                    for(String s : list1){
                        for(String t : list2){
                            for(String u : list3){
                                Project2.resultsList.add(s + "-" + t + "-" + u);
                                Project2.comboListSize++;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Gets all four word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words.
     */
    public static void getFourWordCombos(List<String> words, String number){
        int i,j,k;
        
        for(i=1; i<number.length()-3; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            for(j=i+1; j < number.length()-2; ++j){
                String sSplit = number.substring(i,j);
                String s1 = NumberModifiers.numToStart(sSplit);
                String s2 = NumberModifiers.numToEnd(sSplit);
                
                List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
                for(k=j+1; k < number.length()-1; ++k){
                    String tSplit = number.substring(j,k);
                    String t1 = NumberModifiers.numToStart(tSplit);
                    String t2 = NumberModifiers.numToEnd(tSplit);

                    List<String> list3 = WordMatcher.getWords(words, tSplit, t1, t2);
                    
                    String foSplit = number.substring(k);
                    String fo1 = NumberModifiers.numToStart(foSplit);
                    String fo2 = NumberModifiers.numToEnd(foSplit);
                    
                    List<String> list4 = WordMatcher.getWords(words, foSplit, fo1, fo2);
                    
                    if(!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty()){
                        for(String s : list1){
                            for(String t : list2){
                                for(String u : list3){
                                    for(String v : list4){
                                        Project2.resultsList.add(s + "-" + t + "-" + u + "-" + v);
                                        Project2.comboListSize++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Gets all five word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words.
     */
    public static void getFiveWordCombos(List<String> words, String number){
        int i,j,k,l;
        
        for(i=1; i<number.length()-4; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            for(j=i+1; j < number.length()-3; ++j){
                String sSplit = number.substring(i,j);
                String s1 = NumberModifiers.numToStart(sSplit);
                String s2 = NumberModifiers.numToEnd(sSplit);
                
                List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
                for(k=j+1; k < number.length()-2; ++k){
                    String tSplit = number.substring(j,k);
                    String t1 = NumberModifiers.numToStart(tSplit);
                    String t2 = NumberModifiers.numToEnd(tSplit);

                    List<String> list3 = WordMatcher.getWords(words, tSplit, t1, t2);
                    for(l=k+1; l < number.length()-1; ++l){
                        String foSplit = number.substring(k,l);
                        String fo1 = NumberModifiers.numToStart(foSplit);
                        String fo2 = NumberModifiers.numToEnd(foSplit);

                        List<String> list4 = WordMatcher.getWords(words, foSplit, fo1, fo2);
                        
                        String fiSplit = number.substring(l);
                        String fi1 = NumberModifiers.numToStart(fiSplit);
                        String fi2 = NumberModifiers.numToEnd(fiSplit);
                        
                        List<String> list5 = WordMatcher.getWords(words, fiSplit, fi1, fi2);
                        if(!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty() && !list5.isEmpty()){
                            for(String s : list1){
                                for(String t : list2){
                                    for(String u : list3){
                                        for(String v : list4){
                                            for(String w : list5){
                                                Project2.resultsList.add(s + "-" + t + "-" + u + "-" + v + "-" + w);
                                                Project2.comboListSize++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Gets all six word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words. 
     */
    public static void getSixWordCombos(List<String> words, String number){
        int i,j,k,l,m;
        
        for(i=1; i<number.length()-5; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            for(j=i+1; j < number.length()-4; ++j){
                String sSplit = number.substring(i,j);
                String s1 = NumberModifiers.numToStart(sSplit);
                String s2 = NumberModifiers.numToEnd(sSplit);
                
                List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
                for(k=j+1; k < number.length()-3; ++k){
                    String tSplit = number.substring(j,k);
                    String t1 = NumberModifiers.numToStart(tSplit);
                    String t2 = NumberModifiers.numToEnd(tSplit);

                    List<String> list3 = WordMatcher.getWords(words, tSplit, t1, t2);
                    for(l=k+1; l < number.length()-2; ++l){
                        String foSplit = number.substring(k,l);
                        String fo1 = NumberModifiers.numToStart(foSplit);
                        String fo2 = NumberModifiers.numToEnd(foSplit);

                        List<String> list4 = WordMatcher.getWords(words, foSplit, fo1, fo2);
                        for(m=l+1; m < number.length()-1; ++m){
                            String fiSplit = number.substring(l,m);
                            String fi1 = NumberModifiers.numToStart(fiSplit);
                            String fi2 = NumberModifiers.numToEnd(fiSplit);

                            List<String> list5 = WordMatcher.getWords(words, fiSplit, fi1, fi2);
                            
                            String siSplit = number.substring(m);
                            String si1 = NumberModifiers.numToStart(siSplit);
                            String si2 = NumberModifiers.numToEnd(siSplit);
                            
                            List<String> list6 = WordMatcher.getWords(words, siSplit, si1, si2);
                            if(!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty() && !list5.isEmpty() && !list6.isEmpty()){
                                for(String s : list1){
                                    for(String t : list2){
                                        for(String u : list3){
                                            for(String v : list4){
                                                for(String w : list5){
                                                    for(String x : list6){
                                                        Project2.resultsList.add(s + "-" + t + "-" + u + "-" + v + "-" + w + "-" + x);
                                                        Project2.comboListSize++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Gets all seven word combinations that match the phone number input.
     * @param words the list of words to search.
     * @param number the phone number to compare against the list of words. 
     */
    public static void getSevenWordCombos(List<String> words, String number){
        int i,j,k,l,m,n;
        
        for(i=1; i<=number.length()-6; ++i){
            String fSplit = number.substring(0, i);
            String f1 = NumberModifiers.numToStart(fSplit);
            String f2 = NumberModifiers.numToEnd(fSplit);
            
            List<String> list1 = WordMatcher.getWords(words, fSplit, f1, f2);
            for(j=i+1; j <= number.length()-5; ++j){
                String sSplit = number.substring(i,j);
                String s1 = NumberModifiers.numToStart(sSplit);
                String s2 = NumberModifiers.numToEnd(sSplit);
                
                List<String> list2 = WordMatcher.getWords(words, sSplit, s1, s2);
                for(k=j+1; k <= number.length()-4; ++k){
                    String tSplit = number.substring(j,k);
                    String t1 = NumberModifiers.numToStart(tSplit);
                    String t2 = NumberModifiers.numToEnd(tSplit);

                    List<String> list3 = WordMatcher.getWords(words, tSplit, t1, t2);
                    for(l=k+1; l <= number.length()-3; ++l){
                        String foSplit = number.substring(k,l);
                        String fo1 = NumberModifiers.numToStart(foSplit);
                        String fo2 = NumberModifiers.numToEnd(foSplit);

                        List<String> list4 = WordMatcher.getWords(words, foSplit, fo1, fo2);
                        for(m=l+1; m <= number.length()-2; ++m){
                            String fiSplit = number.substring(l,m);
                            String fi1 = NumberModifiers.numToStart(fiSplit);
                            String fi2 = NumberModifiers.numToEnd(fiSplit);

                            List<String> list5 = WordMatcher.getWords(words, fiSplit, fi1, fi2);
                            for(n=m+1; n <= number.length()-1; ++n){
                                String siSplit = number.substring(m,n);
                                String si1 = NumberModifiers.numToStart(siSplit);
                                String si2 = NumberModifiers.numToEnd(siSplit);

                                List<String> list6 = WordMatcher.getWords(words, siSplit, si1, si2);

                                String seSplit = number.substring(n);
                                String se1 = NumberModifiers.numToStart(seSplit);
                                String se2 = NumberModifiers.numToEnd(seSplit);
                                
                                List<String> list7 = WordMatcher.getWords(words, seSplit, se1, se2);
                                if(!list1.isEmpty() && !list2.isEmpty() && !list3.isEmpty() && !list4.isEmpty() && !list5.isEmpty() && !list6.isEmpty() && !list7.isEmpty()){
                                    for(String s : list1){
                                        for(String t : list2){
                                            for(String u : list3){
                                                for(String v : list4){
                                                    for(String w : list5){
                                                        for(String x : list6){
                                                            for(String y : list7){
                                                                Project2.resultsList.add(s + "-" + t + "-" + u + "-" + v + "-" + w + "-" + x + "-" + y);
                                                                Project2.comboListSize++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

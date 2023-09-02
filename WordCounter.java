package com.CODSOFT;

   import java.io.BufferedReader;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Set;
	import java.util.HashSet;

	public class WordCounter {
	    public static void main(String[] args) {
	        System.out.println("Welcome to Word Counter!");
	        System.out.println("Enter text or provide a file path:");

	                   String inputText = getUserInput();

	        if (inputText.isEmpty()) {
	            System.out.println("No text provided. Exiting.");
	            return;
	        }
	        String[] words = inputText.split("\\s+|\\p{Punct}");

	        int wordCount = 0;

	        Set<String> commonWords = new HashSet<>();
	        commonWords.add("you");
	        commonWords.add("go");

	        Map<String, Integer> wordFrequency = new HashMap<>();

	        for (String word : words) {
	            if (!word.isEmpty()) {
	                wordCount++;

	                if (!commonWords.contains(word.toLowerCase())) {
	                    wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
	                }
	            }
	        }

	        System.out.println("Total words: " + wordCount);

	        System.out.println("Unique words: " + wordFrequency.size());
	        System.out.println("Word frequency:");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }

	    private static String getUserInput() {
	        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
	            StringBuilder inputText = new StringBuilder();
	            String line;
	            while ((line = br.readLine()) != null) {
	                inputText.append(line).append("\n");
	            }
	            return inputText.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "";
	        }
	    }
	}

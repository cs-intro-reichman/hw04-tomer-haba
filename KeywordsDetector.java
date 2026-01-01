public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        // Iterate over each sentence in the sentences array
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            
            // Convert the sentence to lowercase for case-insensitive comparison
            // (Using standard Java library method as implied by context of generic String arrays)
            String lowerSentence = sentence.toLowerCase();

            // Iterate over each keyword
            for (int j = 0; j < keywords.length; j++) {
                String keyword = keywords[j];
                
                // Convert the keyword to lowercase as well
                String lowerKeyword = keyword.toLowerCase();

                // Check if the sentence contains the keyword
                if (lowerSentence.contains(lowerKeyword)) {
                    // Print the ORIGINAL sentence (not the lowercase version)
                    System.out.println(sentence);
                    
                    // Important: Once we found a keyword in this sentence, we print it and 
                    // move to the next sentence. We don't need to check the rest of the keywords
                    // for this specific sentence (avoids printing the same sentence twice).
                    break;
                }
            }
        }
    }
}
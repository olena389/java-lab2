public class Main {

    public static void main(String[] args) {
        // Вхідний текст
        String inputText = "Apples are absolutely amazing and apparently awesome.";

        // Обробка тексту з використанням StringBuffer
        try {
            StringBuffer textBuffer = new StringBuffer(inputText);
            StringBuffer resultBuffer = processText(textBuffer);
            System.out.println("Input text: " + textBuffer);
            System.out.println("Processed text: " + resultBuffer);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Метод для обробки тексту, в якому видаляються всі наступні входження
     * першої літери кожного слова.
     *
     * @param textBuffer текст для обробки у вигляді StringBuffer
     * @return оброблений текст у вигляді StringBuffer
     */
    public static StringBuffer processText(StringBuffer textBuffer) {
        // Перетворення StringBuffer в String для обробки
        String text = textBuffer.toString();
        String[] words = text.split("\\s+"); // Розділення тексту на слова
        StringBuffer processedText = new StringBuffer();

        for (String word : words) {
            if (word.isEmpty()) {
                continue; // Пропустити порожні слова
            }

            char firstChar = word.charAt(0); // Перша літера слова
            StringBuilder wordBuilder = new StringBuilder(word);

            for (int i = 1; i < wordBuilder.length(); i++) {
                if (wordBuilder.charAt(i) == firstChar) {
                    wordBuilder.deleteCharAt(i);
                    i--; // Зміщення назад після видалення символу
                }
            }

            processedText.append(wordBuilder).append(" ");
        }

        // Видалення зайвого пробілу в кінці
        if (processedText.length() > 0) {
            processedText.setLength(processedText.length() - 1);
        }

        return new StringBuffer(processedText);
    }
}

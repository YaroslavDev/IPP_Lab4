IPP_Lab4
========

Nota bene:

- It uses Java
- It is Intellij IDEA project
- It uses Gradle as project management tool
- It uses template method pattern in ArticleAnalyzer class
- It has no branching
- To support “The Economist” articles you need:
  * to add new class which inherits from ArticleAnalyzer and implements extractText() method 
  * add one line to ArticleAnalyzer: mapper.put(“www.economist.com”, EconomistAnalyzer.class);

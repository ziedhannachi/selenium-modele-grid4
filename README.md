<p align="center">
<img width="350" alt="y" src="https://user-images.githubusercontent.com/62071683/85179170-93982080-b280-11ea-8033-9afe7238c044.jpg">
</p>

# Selenium - Cucumber Automatisation de test fonctionnel 

Selenium-Cucumber est une approche de développement piloté par le comportement (Behavior-Driven Development BDD) pour écrire un script de test d'automatisation pour tester une application Web. 
Il vous permet d'écrire et d'exécuter des tests d'acceptation / unitaires automatisés. Il est multiplateforme, open source et gratuit. Automatisez vos cas de test avec un codage minimal.

# Approche

Behavior-Driven Development
(BDD) est une méthode de conception logicielle qui étend TDD, par l’apport de pratiques additionnelles, et qui explore et spécifie les besoins, en mettant l’accent sur la collaboration et en s’appuyant sur les tests et leur scénarisation.
L'automation des tests fait partie de BDD, au même titre qu'avec TDD, tout en élargissant l'utilisation des tests à tous les niveaux de test.

# Script P.O.M 

Les scripts Sélénium sont développés par le design pattern POM :
Une meilleure approche de la maintenance de script consiste à créer un fichier de classe distinct qui trouverait des éléments Web, les remplirait où les vérifierait. Cette classe peut être réutilisée dans tous les scripts utilisant cet élément. S'il y a un changement dans l'élément web, nous devons faire la modification dans seulement 1 fichier de classe.

# Installation (pré-requis)

- JDK 1.8+ (assurez-vous que le chemin d'accès aux classes Java est défini)
- Maven (assurez-vous que le chemin de classe .m2 est défini)
- Eclipse
- Eclipse Plugins pour
    - Maven
    - Cucumber
- Driver du navigateur (Environnement Windows) 

# Importation de la solution

- Cloner la solution depuis le dépôt [Github](https://forge.dgfip.finances.rie.gouv.fr/dgfip/soda/pipelines-selenium/selenium-projet-modele/-/tree/master)
- Ouvrir Eclipse et afficher le Package explorer :
- Click sur Window => Show View => Package Explorer
- Click sur File
- Click sur Import
- Choisir Maven => Existing Maven Projects
- Click sur Browser
- Sélectionner le Projet 
- Ajouter le source folder src/spec/features

# Installation plugin Cucumber

- Ouvrir Eclipse
- Cliquer sur Help
- Cliquer Install New Software
- Cliquer sur le bouton " Add"
- Taper le nom comme vous le souhaitez, exemple " Cucumber " et taper " http://cucumber.github.io/cucumber-eclipse/update-site " comme emplacement. Cliquer OK
- Cochez la case ok et appuyez sur le bouton " Suivant "
- Cliquer sur “I accept the terms of the license agreement” puis cliquer sur Terminer
- Vous pouvez ou non rencontrer un avertissement de sécurité, si vous cliquez simplement sur OK
- Redémarrer Eclipse.

# Installation du fichier ChromeDriver.exe (Environnement Windows) 

   - Aller dans le site https://chromedriver.chromium.org/downloads   
   - Télécharger le fichier chromeDriver.exe compatible avec la version du navigateur
   - Créer un package drivers sous la source folder src/test/resources 
   - Copier-coller dans le dossier drivers  
   - Mettre le path du fichier chromeDriver.exe dans la classe src/test/java/utils/Setup.java
 
#  Où sont écrits les tests ?

Les tests sont écrits dans le repertoire src/spec/feature avec le syntaxe Gherkin
- Gherkin utilise un ensemble de mots clés spéciaux pour donner une structure et un sens aux spécifications exécutables. Gherkin permet d’écrire des scénarios de test compréhensibles par des individus non techniques. Cette approche sert deux objectifs : documenter les fonctionnalités à développer d’une part, et permettre l’automatisation des tests d’autre part.La plupart des lignes d'un document Gherkin commencent par l'un des mots clés:
  - Le “Given” mot-clé précède le texte définissant le contexte; l'état connu du système (ou condition préalable).
  - Le “When” mot-clé précède le texte définissant une action.
  - Le “Then” mot-clé précède le texte définissant le résultat de l'action sur le contexte (ou résultat attendu).
  
# Tags 

Cucumber a fourni un moyen d'organiser l'exécution des scénarii en utilisant des Tags dans le fichier feature. Nous pouvons définir chaque scénario avec une tag utile. Plus tard, dans le fichier runner, nous pouvons décider quel tag spécifique nous voulons que Cucumber exécute. Le tag commence par « @ ». Après « @ », vous pouvez avoir tout texte pertinent pour définir votre tag comme @SmokeTests juste au-dessus des scénarios que vous souhaitez marquer. 
Ensuite, pour cibler ces scénarios tagués, spécifiez simplement les noms des tags dans les options CucumberOptions comme tags = {«@SmokeTests»}.

Le tag ne fonctionne pas uniquement avec les scénarios, il fonctionne également avec les features. Signifie que vous pouvez également taguer vos fichiers features. 
Toute tag qui existe sur une entité sera héritée par un scénario, un scénario Outline ou des exemples.
  
# Exécution des tests avec la classe d'exécution
 
La classe d'exécution de test est l'un des nombreux mécanismes à l'aide desquels vous pouvez exécuter le fichier de fonctionnalité Cucumber. 
La classe d’exécution est sous src/test/java /RunWebSuiteTest.java

- Pour exécuter les cas de test :
  - Choisir les tags à exécuter dans le fichier de fonctionnalité sous src/spec/feautures 
    exemple: @tag dans le fichier CucumberFile.feature
  - Mettre le tags dans l'option tags dans la classe RunWebSuiteTest (voir la capture d'écran)
    
<p align="center">
<img width="350" alt="y" src="https://user-images.githubusercontent.com/28559744/177780511-6ad488be-f5b2-4861-9bbb-cb508622bcb9.PNG">
</p>

  - Cliquer bouton droit sur la classe RunWebSuiteTest.java
  - Choisir Run As
  - Cliquer sur Junit Test
 
 Remarque:
- Si vous souhaitez indiquer à cucumber d'éxécuter un seul scénario:
  - tags = ("@tag")
  
- Si vous souhaitez indiquer à cucumber d'éxécuter plusieurs scénarii:
  - tags = ("@tag1 or @tag2")

   
# Fichier de configuration 

Le fichier de configuration "Config.properties" de l’url de l’environnement de test, grid, login et mots de passe de test se trouve sous src/test/resources/configs

   - Ouvrir le fichier "Config.properties" sous src/test/resources/configs
   - Mettre à jour l’URL pour l’environnement à tester dans "home.url"
   - Mettre à jour l'adresse de la grid en local dans "home.local" 
   - Mettre à jour le login et le mots de passe dans "home.login" et "home.password"
   
# Résultat de test 
 
Les résultats de test s’affichent dans un rapport "cucumber-report.html" sous le dossier Target.

# Synthèse Framework de test auto en BDD

- Approche agile
  - Approche BDD 
- Technologies
  - Cucumber 
    - [Cucumber-JVM pour le BDD](https://cucumber.io/docs/installation/java/#maven)
  - Webdriver pour les UI 
    - [La lib officielle / Selenium (en Java)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
  - Assertion 
    - [Assert (JUnit API)](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)
  - Report 
    - [Cucumber report](https://cucumber.io/docs/installation/java/#maven)
  - Runtime 
    - [JUnit](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)
  - Langage de Scripting
      - JAVA
- Architecture / Structure
  - POM (Page Object Model)
  - features
  - stepDefinitions
  - pageObjects
  - reports
  
  
  


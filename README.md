# excercise4
Exercise 4
Use Java and Selenium to automate the browser and do the steps described in the following paragraphs.
1.	Go to https://github.com/SeleniumHQ/selenium
a.	Open the dialog “Code”
b.	Get the repository clone URL from the input field
c.	Get the number of releases
d.	Write the information gathered (url, releases) represented as json to a file selenium-meta-data.json : (https://github.com/SeleniumHQ/selenium.git,83) 
![image](https://github.com/alexandracalin/excercise/assets/33147145/647f1141-e7a3-4244-984d-a1bcd0379fe8)



2.	Click on tab “Issues”
a.	Clear search field and type “sort:comments-desc”
b.	Filter by label “C-java”
c.	Click “Open”
d.	Get the following attributes of the first (most top) issue displayed
i.	title
ii.	labels
iii.	number of comments
iv.	issue’s id
v.	author
vi.	created (Date/time)
e.	Write the information gathered represented as json to a file most-discussed-java-issue.json

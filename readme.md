<img align="center" width="340" height="120" src="crawler-image.png">


# Crawler mmmmmCrawler
Header H1 is used to display the Project heading.

## Sub Topic Headings H2
Sub Topic Headings H2 is used for sub sections like Configurations, Authors etc.

````
pip install boto
````

The above formatting is used to create a box which can display code or command in a well formatted manner.


## Usage

Below is another example of displaying
````python
import csv

with open("sample.csv","r") as csvinput: # read input csv file
    reader = csv.reader(csvinput) # create a reader
    for row in reader:
        print(row[0])
````
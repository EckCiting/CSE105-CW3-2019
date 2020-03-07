# CSE105-CW3-2019
Personal code for CSE105 Courcework 3. Released after the announcement of 2019-2020 semester 1 final exam results . 

Note:
This project is mainly used for code backup.
The initial upload time is March 7, 2020, which is after the 2019-2020 S1 results announcement. If the homework for CSE105 CW3 in 2019 looks similar to this Repository, it cannot be considered plagiarism.


Class description:
The classes is divided into 3 parts: Main, Data and GUI.

Main Part only contains Main Class. It is the entrance of the hole project. It also set colour and animal icon by modifying constants: BACKGROUND_COLOR and ICON.

Data Class and FileUtil Class are the Data part. Data class is to store animal information which contains country name and animal number. FileUtil Class has tools for manipulating files and pictures. 

GUI part contains GUI class and many custom label, panel and frame classes. GUI class is used to display everything. Meanwhile it can set attributes for frames, panels and labels automatically by reading and analyzing animal_data.csv.


Usage:
The programme can build the Pictograph automatically after following rules:

1. Change the data according to the following format:
   First line: Animal Name (1 word) + " populations in " + Location
   Other lines: Country Name + ',' + Number of Animals

2. Choose a suitable picture to represent the animal.

3. Choose your favourite color.

4. Run the Main Class (This project is not yet packaged so you need to run the souce code)

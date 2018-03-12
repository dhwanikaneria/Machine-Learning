Unzip and Open the Command Prompt(Terminal at the PartII folder)


The ID3 algorithm was implemented using Java in Eclipse IDE.
The program will compile in the IDE with no errors. If IDE is not used, can compile using the
following command in the cmd/terminal:

Source folder contains all required java files 

1) javac *.java //will compile all the .java files



Command Line Arguments:: TrainingData ValidationData TestingData PruningFactor

2)	Run the Model for DataSet1::
	java ID3 data_sets1/training_set.csv data_sets1/validation_set.csv data_sets1/test_set.csv 20.0
	

	OR
	Run the Model for DataSet2::
	java ID3 data_sets2/training_set.csv data_sets2/validation_set.csv data_sets2/test_set.csv 20.0

	(You can Replace the 20.0 With whatever fraction of the total number of nodes you may want to test with).

You can see the Output of the program on both the Dataset in the file attached, OUTPUT1.txt and OUTPUT2.txt, respectively.

O/P Order::

1)Pre-Pruned Tree

2)Pre-Pruned Accuracy

3)Post-Pruned Tree

4)Post-Pruned Accuracy
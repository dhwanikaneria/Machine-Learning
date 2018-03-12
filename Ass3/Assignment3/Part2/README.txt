Unzip and Open the Command Prompt(Terminal at the PartII folder)


The BackPropagation algorithm was implemented using Java in Eclipse IDE.
The program will compile in the IDE with no errors. If IDE is not used, can compile using the
following command in the cmd/terminal:

Source folder contains all required java files 

1) javac *.java //will compile all the .java files




------------------------------------------------Preprocessing Data------------------------------------------------|
Command Line Arguments:: InputFile OutputFile

Run the following commands for different dataset

1) java PreProcessing data/iris.data.csv data/preProcessed_iris.csv 
O/P::
File Created :: preProcessed_iris.csv
lenght of file:  150

2) java PreProcessing data/adult.data.csv data/preProcessed_adult.csv
O/P::
File Created :: preProcessed_adult.csv
lenght of file:  30162

3)java PreProcessing data/car.data.csv data/preProcessed_car.csv
O/P::
File Created :: preProcessed_car.csv
lenght of file:  1728

------------------------------------------------Running ANN----------------------------------------------------------|

Command Line Arguments:: InputFile TrainingSize MaxIteration NumberofHiddenLayer NumberofNeurons

Run the following Commands for different dataset

1) java BackPropagation data/preProcessed_iris.csv 85 150 2 5 3

2) java BackPropagation data/preProcessed_adult.csv 85 250 2 8 5

3) java BackPropagation data/preProcessed_car.csv 85 200 3 8 5 3

O/P ::

Layer : 0

Neuron : 1 Weights : 0.8980874693051545   0.9696431784638665   0.24344471669044662   -0.6868125213991212   -0.16474968266745119   
Neuron : 2 Weights : 0.32386532466823637   0.9590136249589855   -0.6032750957274909   0.9446990256432639   0.16772667822777096   
Neuron : 3 Weights : 0.6189911435923904   0.7708566986294049   -0.4054299618349941   0.07041386604271697   0.002960466783106787   
Neuron : 4 Weights : -0.8682236675013352   0.025874711694425095   -0.950275235934298   0.15988747789848512   -0.7861320295635743   
Neuron : 5 Weights : 1.0071260969081846 0.3048471857218805 0.34818365733878553 -0.06857528962523703 0.12577189743914252 

Layer : 1


Neuron : 1 Weights : -0.6311925202780356   0.558087797543726   -0.231690722165752   
Neuron : 2 Weights : 0.8227075376757668   -0.0356195848780562   -0.5643027776736649   
Neuron : 3 Weights : 0.7455612471607759   -0.8904711799987248   -0.3119847331540146   
Neuron : 4 Weights : -0.29279634334203775   0.285578762993499   -0.0427715902047001   
Neuron : 5 Weights : -0.5563122529209789   -0.7083301749293778   0.8095542445666428   
Neuron : 6 Weights : -0.07786499563221237   0.5243400481802402   0.9713588367336866   

Layer : 2


Neuron : 1 Weights : -0.12296466626248478   -0.17557001236098133   
Neuron : 2 Weights : -0.34460491377879654   0.8147659265915645   
Neuron : 3 Weights : -0.5453314870852068   0.04519428057808614   
Neuron : 4 Weights : -0.3253475436757736   0.010246840662981475   

Layer : 3


Neuron : 1 Weights : 0.8451877061253619   
Neuron : 2 Weights : 0.023841020146797558   
Neuron : 3 Weights : 2.2145702971850745   

Total Training Error : 0.006299212598425202
Training Accuracy : 68.50393700787401

Total Testing Error:0.0034782608695652197
Testing Accuracy : 82.6086956521739

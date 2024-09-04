# sudoku-solver
SUDOKU SOLVER : JAVA or Python

----------

At LEAST 3 Deduction rules :

must have a class deduction rules => fct run(); => 3 deductions rules

----------

late binding

Groupe of 2

Deadline : 3 Novembre 2024

/!\ Github mandatory /!\

rapport /!\ PDF /!\

Use 4 design patterns

read a HowTo markdown file

/!\ 2 points on the way the project is sent /!\

/!\ Zip file or Github /!\

Projet Genie Logiciel 2024

Résolution de grille de sudoku

Il s'agit de développer un solver de sudoku qui doit essayer de résoudre une grille de sudoku en appliquant un
ensembl de regles de déductions. Au moins trois regles de deductions doivent etre définies et utilisées
Ces trois regles : DR1, DR2 et DR3 représentées par les classes du même nom, doivent dérivées d'une classe DeductionRule. L'algorithme de déduction utilisé doit procéder de la facon suivante : quand une valeur est fixée dans une case, les règles doivent etre appliquées successivement. Apres répétition de ce processus, s'il reste des cases vides alors on doit demander à l'utilisateur de mettre une valeur dans une case. Pour démarrer le solver considère la grille vide et ajoute les valeurs de départ les unes après les autres.

Le projet doit obligatoirement
- etre développé en java ou python (pas de jupiter python)
- etre associé à un github
- le github doit contenir une explication (écrite en markdown) sur l'utilisation du programe
- le github doit contenir un rapport sous la forme d'un pdf. Le rapport doit présenter les problèmes, présenter votre solution et commenter les choix
- la fin du projet est le 3 Nov 2024 23:59 AoE
- l'affichage doit etre simple et compte très peu dans la note finale
- le format d'entrée de grille doit etre un tableau de 81 éléments avec -1 quand une case est vide et les nombres sinon (on compte à partir de 1). La grille est donc linéariser (les lignes se suivent dans le tableau)
- l'adresse web du dépôt github doit être envoyée par email à JC Regin (jcregin@gmail.com) avant la fin du projet. L'objet de l'email doit être uniquement «SE github». 
- Le nom des auteurs doit être ajouté dans le github et dans le rapport.

Le projet contient une question bonus:
Il faut engendrer des sudoku avec leur difficulté
un sudoku qui est entièrement résolu par DR1 est facile
un sudoku qui n'est pas résolu par DR1 mais qui l'est entièrement par DR2 est moyen
un sudoku qui n'est pas résolu par DR2 mais qui l'est entièrement par DR3 est difficile
un sudoku qui n'est pas résolu par DR3 est très difficile.

Le projet implique deux personnes maximum et il doit etre concu, implementé et documenté entièrement et exclusivement par ces deux personnes

Faire le projet seul ne donne pas lieu à des bonus

Je me réserve le droit de faire passer un oral pour obtenir de plus amples informations.

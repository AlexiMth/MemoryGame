
# Memory Game

### Introduction

Nous avons eu à effectuer un projet de jeu de mémoire en JavaFX. Pour ce faire, nous avons eu un cahier des charges à respecter avec tous les éléments demandés.


### Etat actuel du projet

A l'heure actuel, j'ai réussi à faire fonctionner certains éléments, mais d'autres que je n'ai pas réussi à mettre en place correctement.

### Elements fonctionnels

J'ai quelques éléments qui fonctionnent. J'ai su mettre en place l'interface grâce à SceneBuilder. J'ai affiché un titre de jeu, un timer qui une fois arrivé à 0, affiche un message "Fin de partie". J'ai mis en place un bouton "Lancer" qui permet de lancer la partie, et un ChoiceBox qui permet de choisir la difficulté du jeu. Lorsque quelqu'un termine le jeu, il obtient un message "Fin de jeu, vous avez gagné!" et le timer s'arrête. Lorsque deux cartes retournées sont différentes, elles restent 1 seconde face découverte puis se retournent face cachée. Lorsque deux cartes identiques sont trouvées, elles sont alors semi-invisible (opacité à 0.5) pour montrer qu'elles ont été trouvées. Chaque carte peut être retournée sans problème.

### Elements non fonctionnels ou non implémentés

Les différentes difficultés sont affichées mais n'ont pas été implémentées, donc peu importe le niveau de difficulté, il y aura toujours autant de cartes. Les sons, les animations et tout autres effets n'ont pas été implémentés, car ils n'ont pas été jugés prioritaires sur ce projet. Le score n'a pas non plus été implémenté, ni le bouton pour recommencer.

### Difficultés rencontrées

J'ai eu du mal à prendre en main JavaFX. Etant donné le peu d'heures que nous avions eu et que nous n'avons pas le droit de le travailler en dehors des heures prévues, j'ai eu du mal à avancer au départ surtout que j'avais, sans m'en rendre compte, imbriqué deux BorderPane ce qui m'a énormément bloqué jusqu'à 2h avant la fin du projet. Ces BorderPanes cachés les cartes, ce qui me faisait croire pendant plusieurs heures que mon code n'affichait pas bien les cartes. Etant donné que je ne suis pas à l'aise en Java, j'ai eu du mal à m'approprier ce projet mais j'ai pu faire l'essentiel.

### Comment les soucis rencontrés auraient pu être évités

Pour mieux démarrer le projet, j'aurais pu essayer de faire une petite conception, afin de voir plus clair sur ce qui était attendu. Je suis assez désordonné de base, ce qui rend le projet plus compliqué puisque je jonglais entre les classes.

### Remarques sur ce projet

Ce projet m'a fait peur aux premiers abords, mais on se rend rapidement compte que ça fait partie du métier d'ingénieur. Il faut savoir s'adapter à la situation, savoir choisir minutieusement les éléments les plus importants dans le cas où l'ont sait qu'on n'arrivera pas à respecter à 100% le cahier des charges (mon cas). De ce point de vue ci, je trouve que le projet a été très intéressant dans la manière dont il s'est déroulé.

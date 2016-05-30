# ascii-clock

Prints a clock face given a time in the format hh:mm.

- The 'h' represents the hours
- The 'm' represents the minutes
- The 'x' represents when the hour and the minute both fall on the same mark


## Installation:

- Requires leiningen, you can download it [here](http://leiningen.org/)

```bash
$ git clone https://github.com/pameck/ascii-clock-face
$ cd ascii-clock-face
```

## Usage:

```bash
$ ./go.sh [time]

Options:
time      The time to print, format hh:mm
```

## Examples:
```bash
$ ./go.sh 20:30

   o
  o o
 o   o
o     o
 h   o
  o o
   m
```


```bash
$ ./go.sh
What time do you want me to print?
> 15:50

   o
  o o
 m   o
o     h
 o   o
  o o
   o
```

```bash
$ ./go.sh 06:30

   o
  o o
 o   o
o     o
 o   o
  o o
   x
```

## Collaborators:
This is a family business:

[Pam Rucinque](https://github.com/pameck) & [Andres Castano](https://github.com/afcastano)
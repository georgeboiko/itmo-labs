#!/bin/bash

#создание начальной директории
mkdir lab0

#создание дерева
cd lab0
mkdir aggron4
cd aggron4
mkdir gloom
touch venusaur ledian
echo "Тип покемона GRASS POISON" > venusaur
echo "Ходы Air Cutter Bug Bite
Comet Punch≠ Drain Punch Dynamicpunch Focus Punch Giga Drain Ice Punch
Knock Off Mega Punch Mud-Slap Ominous Wind Rollout Roost Sleep Talk
Snore String Shot Swift Tailwind Thunderpunch Uproar" > ledian
cd ../
mkdir mantyke6
cd mantyke6
mkdir lillipup kingdra misdreavus 
touch mankey
echo "Тип покемона FIGHTING NONE" > mankey
cd ../
touch pupitar5
echo "Способности Mountain Peak Landslide
Shed Skin Rock Head" > pupitar5
mkdir togepi2
cd togepi2
mkdir venomoth pidgeotto
touch conkeldurr patrat
echo "Способности Focus Energy Bide Low
Kick Rock Throw Wake-Up Slap Chip Away Bulk Up Rock Slide Dynamicpunch
Scary Face Hammer Arm Stone Edge Focus Punch Superpower" > conkeldurr
echo "Тип диеты Herbivore" > patrat
cd ../
touch wingull4 wynaut4
echo "Тип диеты Omnivore" > wingull4
echo "Способности 
Mind Mold Shadow Tag Unaware" > wynaut4

#раздача прав
chmod 764 aggron4
chmod 511 aggron4/gloom 
chmod 046 aggron4/venusaur 
chmod 440 aggron4/ledian 
chmod 752 mantyke6 
chmod 357 mantyke6/lillipup 
chmod 357 mantyke6/kingdra 
chmod 440 mantyke6/mankey 
chmod 335 mantyke6/misdreavus 
chmod 062 pupitar5 
chmod 711 togepi2 
chmod 755 togepi2/venomoth 
chmod 753 togepi2/pidgeotto 
chmod 062 togepi2/conkeldurr 
chmod 066 togepi2/patrat 
chmod 600 wingull4 
chmod 006 wynaut4

#пункт 3
cat wingull4 > togepi2/conkeldurrwingull
ln wingull4 mantyke6/mankeywingull
cp wingull4 mantyke6/misdreavus
#для пункта 3.4: создал временную директорию и временно выдал права
chmod u+r mantyke6/lillipup
chmod u+r mantyke6/kingdra
chmod u+r mantyke6/misdreavus
mkdir temp
cp -rp mantyke6 temp
chmod u-r mantyke6/lillipup
chmod u-r mantyke6/kingdra
chmod u-r mantyke6/misdreavus
cp -rp temp/mantyke6 mantyke6/misdreavus
chmod u-r mantyke6/misdreavus/mantyke6/lillipup
chmod u-r mantyke6/misdreavus/mantyke6/kingdra
chmod u-r mantyke6/misdreavus/mantyke6/misdreavus
rm -rf temp
#ln -s source target, в этом случае source - относительный путь
#так как source - относительный путь, то он интерпретируется относительно каталога target:
ln -s ../wingull4 aggron4/venusaurwingull
#выдал временные права:
chmod u+r togepi2/conkeldurr
cat togepi2/conkeldurr togepi2/conkeldurr > wingull4_70
chmod u-r togepi2/conkeldurr
#далее
ln -s aggron4 Copy_89

ls -lR

#пункт 4
echo "Task 4.1"
grep -cr --include="4$" . 2>&1 | sort -t ":" -nk2 -r

echo "Task 4.2"
ls -ltR1 2>>/tmp/errors | grep "^-.* .* .* .* .*.* .* .* .*man.*" | sort

echo "Task 4.3"
grep -hnr --include="4$" . | sort -t ":" -k2

echo "Task 4.4"
ls -ltR1 2>/dev/null | grep "^-.* .* .* .* .*.* .* .* v.*" | sort

echo "Task 4.5"
ls -ltR1 2>&1 | grep "^-.* .* .* .* .*.* .* .* .*r$" | sort -t " " -k9 | head -n 2

echo "Task 4.6"
grep -hnr --include="l*" . 2>>/tmp/errors | sort -t ":" -k2


#пункт 5
rm wingull4
rm -f mantyke6/mankey
rm Copy_89
rm mantyke6/mankeywingull
rm -rf togepi2
rm -rf togepi2/pidgeotto

### Oplossing Block Dude 6

`Factory` kan je vervangen door `Supplier<Actor>`. 

`Generator` kan je vervangen door `BiConsumer<Integer,Integer>` maar dat
is niet 100% ideaal omwille van de wikkelklassen. Jammer dat er 
geen `IntBiConsumer` bestaat.
Tip bij Maximizer
===

Wil je aangeven dat de typeparameter *T* een *comparable* moet zijn,
schrijf dan

     public class Maximizer<T extends Comparable<T>> …

Let op de tweede *T* in deze hoofding. 
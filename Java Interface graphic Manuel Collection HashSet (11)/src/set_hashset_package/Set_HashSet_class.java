package set_hashset_package;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

// set Collection Interface
// HashSet Collection Class
 

 class Set_HashSet_class {
     Set set;
  void Ajouter(){
 set = new HashSet();
 set.add("Element1");
 set.add("Element2");
 set.add("Element3");
 set.add("Element4");
  }
     
 void Afficher(){
 Iterator it = set.iterator() ;
 while (it.hasNext ( ) )
 {
 System.out.println(it.next( ) ) ; 
}    
    }

    public static void main(String[] args) {
         Set_HashSet_class SHc = new Set_HashSet_class();
        SHc.Ajouter();
        SHc.Afficher();
    }
    
}

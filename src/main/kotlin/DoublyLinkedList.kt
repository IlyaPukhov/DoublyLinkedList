class DoublyLinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null


    /** Добавление элемента в голову двусвязного списка. */
    fun push(x: T) {
        val node = Node(x)
        if (head == null) {   //если список пуст, то голова и хвост - это один узел
            head = node
            tail = node
        } else {
            val oldHead = head //сохраняем "старую" голову
            head = Node(x, oldHead, null) //создаем "новую" голову со ссылками на прошлую и на null
            head?.next?.prev = head

        }
    }

    /** Добавление элемента в хвост двусвязного списка. */
    fun addTail(x: T) {
        val node = Node(x)
        if (head == null) {    //если список пуст, то голова и хвост - это один узел
            head = node
            tail = node
        } else {
            val oldTail = tail //сохраняем "старый" хвост
            tail = Node(x, null, oldTail) //создаем "новый" хвост со ссылками на прошлую и на null
            tail?.prev?.next = tail
        }
    }

    /** Удаление элемента из головы двусвязного списка. */
    fun pop(): T? {
        val value = head?.value //сохраняем значение "старой" головы
        head = head?.next //голова теперь - узел, находившийся за "старой" головой
        head?.prev = null //новая голова ссылается на null
        return value //возвращаем значение удаленной головы
    }

    /** Удаление элемента из хвоста двусвязного списка. */
    fun delTail(): T? {
        val value = tail?.value //сохраняем значение "старого" хвоста
        tail = tail?.prev //хвост теперь - узел, находившийся перед "старым" хвостом
        tail?.next = null //новый хвост ссылается на null
        return value //возвращаем значение удаленного хвоста
    }
}
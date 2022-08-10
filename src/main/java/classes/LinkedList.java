package classes;

public class LinkedList<T> {
    private class Element {
        private T value;
        private Element prevElement;
        private Element nextElement;

        public Element(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
        public Element getPrevElement() {
            return prevElement;
        }
        public Element getNextElement() {
            return nextElement;
        }
        public void setPrevElement(Element prevElement) {
            this.prevElement = prevElement;
        }
        public void setNextElement(Element nextElement) {
            this.nextElement = nextElement;
        }
    }

    private Element firstElement;
    private Element lastElement;
    private int size;

    public LinkedList() {
        firstElement = null;
        lastElement = null;
        size = 0;
    }

    public void add(T e) {
        Element element = new Element(e);
        if (firstElement == null) {
            firstElement = element;
            lastElement = element;
        } else {
            element.setPrevElement(lastElement);
            lastElement.setNextElement(element);
            lastElement = element;
        }
        size++;
    }
    public void removeLast() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            firstElement = null;
            lastElement = null;
        } else {
            lastElement = lastElement.getPrevElement();
            lastElement.setNextElement(null);
        }
        size--;
    }
    public void removeFirst() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            firstElement = null;
            lastElement = null;
        } else {
            firstElement = firstElement.getNextElement();
            firstElement.setPrevElement(null);
        }
        size--;
    }
    public void addFirst(T e) {
        Element element = new Element(e);
        if (firstElement == null) {
            firstElement = element;
            lastElement = element;
        } else {
            element.setNextElement(firstElement);
            firstElement.setPrevElement(element);
            firstElement = element;
        }
        size++;
    }
    public void remove(int position) {
        if (position >= size | position < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Element element = null;
            while (position >= 0) {
                if (element == null) {
                    element = firstElement;
                } else {
                    element = element.getNextElement();
                }
                position--;
            }
            element.getPrevElement().setNextElement(element.getNextElement());
            element.getNextElement().setPrevElement(element.getPrevElement());
            size--;
        }
    }
    public T get(int position) {
        if (position >= size | position < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Element element = null;
            while (position >= 0) {
                if (element == null) {
                    element = firstElement;
                } else {
                    element = element.getNextElement();
                }
                position--;
            }
            return element.getValue();
        }
    }
    public int indexOf(T e) {
        int position = 0;
        Element element = null;
        while (position < size) {
            if (element == null) {
                element = firstElement;
            } else {
                element = element.getNextElement();
            }
            if (e.equals(element.getValue())) {
                return position;
            }
            position++;
        }
        return position == size ? -1 : position;
    }
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String str = "[";

        Element element = firstElement;
        while (element != null) {
            str += element.getValue() + ", ";
            element = element.nextElement;
        }
        str = str.length() == 1 ? str : str.substring(0, str.length() - 2) + "]";
        return str;
    }
}

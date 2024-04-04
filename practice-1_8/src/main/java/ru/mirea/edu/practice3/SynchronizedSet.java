package ru.mirea.edu.practice3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SynchronizedSet<T> implements Set<T> {
    private final Semaphore semaphore;
    private final Set<T> set;

    public SynchronizedSet() {
        this.set = new HashSet<>();
        this.semaphore = new Semaphore(1);
    }

    @Override
    public int size() {
        try {
            this.semaphore.acquire();
            return this.set.size();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            this.semaphore.acquire();
            return this.set.isEmpty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            this.semaphore.acquire();
            return this.set.contains(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public Iterator<T> iterator() {
        try {
            this.semaphore.acquire();
            return this.set.iterator();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            this.semaphore.acquire();
            return this.set.toArray();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        try {
            this.semaphore.acquire();
            return this.set.toArray(a);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean add(T t) {
        try {
            this.semaphore.acquire();
            return this.set.add(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            this.semaphore.acquire();
            return this.set.remove(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            this.semaphore.acquire();
            return this.set.retainAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            this.semaphore.acquire();
            return this.set.addAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            this.semaphore.acquire();
            return this.set.retainAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            this.semaphore.acquire();
            return this.set.removeAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }

    @Override
    public void clear() {
        try {
            this.semaphore.acquire();
            this.set.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.semaphore.release();
        }
    }
}

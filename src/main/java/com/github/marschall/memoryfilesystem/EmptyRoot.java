package com.github.marschall.memoryfilesystem;

import java.net.URI;
import java.net.URISyntaxException;

import static com.github.marschall.memoryfilesystem.MemoryFileSystemProvider.SCHEME;

class EmptyRoot extends Root {

  static final String SLASH = "/";

  EmptyRoot(MemoryFileSystem fileSystem) {
    super(fileSystem);
  }
  
  @Override
  boolean isNamed() {
    return false;
  }

  @Override
  public boolean startsWith(String other) {
    // intentionally trigger NPE if other is null (default file system behaves the same way)
    return other.equals(SLASH);
  }


  @Override
  public boolean endsWith(String other) {
    // intentionally trigger NPE if other is null (default file system behaves the same way)
    return other.equals(SLASH);
  }

  @Override
  public String toString() {
    return SLASH;
  }

  @Override
  public URI toUri() {
    try {
      return new URI(SCHEME, getMemoryFileSystem().getKey() + ":///", null);
    } catch (URISyntaxException e) {
      throw new AssertionError("could not create URI");
    }
  }

}
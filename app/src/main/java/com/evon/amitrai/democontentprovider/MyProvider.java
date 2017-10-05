package com.evon.amitrai.democontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by amitrai on 4/10/17.
 * User for :-
 */

public  class MyProvider extends ContentProvider {
    @Override
    public  boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public  Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public  String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public  Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public  int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public  int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

//
//
//
//
//
//
//


//
//
//
//
//
//
//
//
//
//    private static final UriMatcher sUriMatcher;
//
//    private static final int NOTES_ALL = 1;
//    private static final int NOTES_ONE = 2;
//
//    static {
//        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        sUriMatcher.addURI(PlatesData.AUTHORITY, "plates", NOTES_ALL);
//        sUriMatcher.addURI(PlatesData.AUTHORITY, "plates/#", NOTES_ONE);
//    }
//
//    // Map table columns
//    private static final HashMap<String, String> sNotesColumnProjectionMap;
//    static {
//        sNotesColumnProjectionMap = new HashMap<String, String>();
//        sNotesColumnProjectionMap.put(PlatesData.Plates._ID,
//                PlatesData.Plates._ID);
//        sNotesColumnProjectionMap.put(PlatesData.Plates._TITLE,
//                PlatesData.Plates._TITLE);
//        sNotesColumnProjectionMap.put(PlatesData.Plates._CONTENT,
//                PlatesData.Plates._CONTENT);
//    }
//
//    private static class NotesDBHelper extends SQLiteOpenHelper
//
//    {
//
//        public  NotesDBHelper(Context c) {
//            super(c, PlatesData.DATABASE_NAME, null,
//                    PlatesData.DATABASE_VERSION);
//        }
//
//        private static final  String SQL_QUERY_CREATE = "CREATE TABLE "
//                + PlatesData.Plates.TABLE_NAME + " (" + PlatesData.Plates._ID
//                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + PlatesData.Plates._TITLE + " TEXT NOT NULL, "
//                + PlatesData.Plates._CONTENT + " TEXT NOT NULL" + ");";
//
//        @Override
//        public  void onCreate(SQLiteDatabase db) {
//            db.execSQL(SQL_QUERY_CREATE);
//        }
//
//        private static final  String SQL_QUERY_DROP = "DROP TABLE IF EXISTS "
//                + PlatesData.Plates.TABLE_NAME + ";";
//
//        @Override
//        public  void onUpgrade(SQLiteDatabase db, intoldVer, intnewVer) {
//            db.execSQL(SQL_QUERY_DROP);
//            onCreate(db);
//        }
//    }
//
//    // create a db helper object
//    private NotesDBHelper mDbHelper;
//
//    @Override
//    public  boolean onCreate() {
//        mDbHelper = new NotesDBHelper(getContext());
//        return false;
//    }
//
//    @Override
//    public int delete(Uri uri, String where, String[] whereArgs) {
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//        int count = 0;
//        switch (sUriMatcher.match(uri)) {
//            caseNOTES_ALL:
//            count = db.delete(PlatesData.Plates.TABLE_NAME, where, whereArgs);
//            break;
//
//            case NOTES_ONE:
//            String rowId = uri.getPathSegments().get(1);
//            count = db.delete(
//                    PlatesData.Plates.TABLE_NAME,
//                    PlatesData.Plates._ID
//                            + " = "
//                            + rowId
//                            + (!TextUtils.isEmpty(where) ? " AND (" + where
//                            + ")" : ""), whereArgs);
//            break;
//
//            default:
//                throw  new IllegalArgumentException("Unknown URI: " + uri);
//        }
//
//        getContext().getContentResolver().notifyChange(uri, null);
//        return count;
//    }
//
//    @Override
//    public  String getType(Uri uri) {
//
//        switch (sUriMatcher.match(uri)) {
//            case NOTES_ALL:
//            return PlatesData.CONTENT_TYPE_PLATES;
//
//            case NOTES_ONE:
//            return PlatesData.CONTENT_TYPE_PLATE;
//
//            default:
//                throw  new IllegalArgumentException("Unknown URI: " + uri);
//        }
//    }
//
//    @Override
//    public  Uri insert(Uri uri, ContentValues values) {
//
//        // you cannot insert a bunch of values at once so throw  exception
//        if (sUriMatcher.match(uri) != NOTES_ALL) {
//            throw  new IllegalArgumentException(" Unknown URI: " + uri);
//        }
//
//        // Insert once row
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//        long rowId = db.insert(PlatesData.Plates.TABLE_NAME, null, values);
//        if (rowId> 0) {
//            Uri notesUri = ContentUris.withAppendedId(PlatesData.CONTENT_URI,
//                    rowId);
//            getContext().getContentResolver().notifyChange(notesUri, null);
//            return notesUri;
//        }
//        throw new IllegalArgumentException("<Illegal>Unknown URI: " + uri);
//    }
//
//    // Get values from Content Provider
//    @Override
//    public  Cursor query(Uri uri, String[] projection, String selection,
//                        String[] selectionArgs, String sortOrder) {
//        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
//        switch (sUriMatcher.match(uri)) {
//            caseNOTES_ALL:
//            builder.setTables(PlatesData.Plates.TABLE_NAME);
//            builder.setProjectionMap(sNotesColumnProjectionMap);
//            break;
//
//            caseNOTES_ONE:
//            builder.setTables(PlatesData.Plates.TABLE_NAME);
//            builder.setProjectionMap(sNotesColumnProjectionMap);
//            builder.appendWhere(PlatesData.Plates._ID + " = "
//                    + uri.getLastPathSegment());
//            break;
//
//            default:
//                throw new IllegalArgumentException("Unknown URI: " + uri);
//        }
//
//        SQLiteDatabase db = mDbHelper.getReadableDatabase();
//        Cursor queryCursor = builder.query(db, projection, selection,
//                selectionArgs, null, null, null);
//        queryCursor.setNotificationUri(getContext().getContentResolver(), uri);
//
//        return queryCursor;
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues values, String where,
//                     String[] whereArgs) {
//
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//        int count = 0;
//        switch (sUriMatcher.match(uri)) {
//            caseNOTES_ALL:
//            count = db.update(PlatesData.Plates.TABLE_NAME, values, where,
//                    whereArgs);
//            break;
//
//            case NOTES_ONE:
//            String rowId = uri.getLastPathSegment();
//            count = db
//                    .update(PlatesData.Plates.TABLE_NAME,
//                            values,
//                            PlatesData.Plates._ID
//                                    + " = "
//                                    + rowId
//                                    + (!TextUtils.isEmpty(where) ? " AND ("
//                                    + ")" : ""), whereArgs);
//
//            default:
//                throw new IllegalArgumentException("Unknown URI: " + uri);
//        }
//        getContext().getContentResolver().notifyChange(uri, null);
//        return count;
//    }


}

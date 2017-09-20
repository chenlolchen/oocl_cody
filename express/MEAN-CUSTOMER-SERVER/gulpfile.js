(function () {
    'use strict';
    const gulp = require('gulp'),
        nodemon = require('gulp-nodemon'),
        watch = require('gulp-watch'),
        livereload = require('gulp-livereload'),
        _paths = ['server/**/*.js'];

    //register nodemon task
    gulp.task('nodemon', function () {
        nodemon({
            script: 'server/app.js',
            env: {
                'NODE_ENV': 'development'
            }
        }).on('restart');
    });

    // Rerun the task when a file changes
    gulp.task('watch', function () {
        livereload.listen();
        gulp.src(_paths, {
            read: false
        }).pipe(watch({
            emit: 'all'
        }));
        watch(_paths, livereload.changed);
    });

    gulp.task('default', ['nodemon', 'watch']);
}());

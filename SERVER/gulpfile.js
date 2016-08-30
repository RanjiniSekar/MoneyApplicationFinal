var gulp = require('gulp');
var nodemon = require('gulp-nodemon');

gulp.task('default', function () {
    nodemon({
        script: 'app.js',
        extension: 'js',
        env: {
            PORT: 8000,
            LISTENIP: 0.0.0.0
        },
        ignore: ['./node_modules/**']
    }).on('restart', function () {
        console.log('Restarting...');
    })
});
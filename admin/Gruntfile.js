module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';',
            },
            dist: {
                src: ['src/main/webapp/script/app.js','src/main/webapp/services/*.js', 'src/main/webapp/controller/*.js','src/main/webapp/app-services/*.js'],
                dest: 'src/main/webapp/script/hmis-admin.js',
            },
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'src/main/webapp/script/hmis-admin.js',
                dest: 'src/main/webapp/script/hmis-admin.min.js'
            }
        },
        mavenPrepare: {
            options: {
                resources: ['src/main/webapp/**']
            },
            prepare: {}
        },
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-maven');

    // Default task(s).
    grunt.registerTask('default', ['concat','uglify']);

};
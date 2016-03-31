exports.config = {
  framework: 'mocha',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['todo-spec.js'],
  capabilities: {
    'browserName': 'firefox' // or 'safari'
	}
};
